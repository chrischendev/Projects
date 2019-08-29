# -*- coding: utf-8 -*-
# 运行命令 在scrapy.cfg同级目录 scrapy crawl ccnovel -o ccnovel_scrapy_list.csv
from scrapy.linkextractors import LinkExtractor
from scrapy.spiders import CrawlSpider, Rule


class CcnovelSpider(CrawlSpider):
    name = 'ccnovel'
    allowed_domains = ['ccnovel.com']
    start_urls = ['http://www.ccnovel.com/']

    rules = (
        Rule(LinkExtractor(allow=r'http://www.ccnovel.com/*'), callback='parse_html', follow=True),
    )

    def parse_html(self, response):
        item = {}

        # 这里在浏览器相应位置复制XPath
        # 获取列表
        news_item_list = response.xpath('/html/body/section/div/div/article')
        # 遍历解析
        for news_item in news_item_list:
            title = news_item.xpath('./h2/a/text()').extract_first()
            url = news_item.xpath('./h2/a/@href').extract_first()
            main_image = news_item.xpath('./a/img/@src').extract_first()
            description = news_item.xpath('./p/text()').extract_first()
            sub_time = news_item.xpath('./footer/time/text()').extract_first()
            news_type = news_item.xpath('./footer/span[1]/a/text()').extract_first()
            tags = news_item.xpath('./footer/span[2]/a/text()').extract()

            # item['domain_id'] = response.xpath('//input[@id="sid"]/@value').get()
            # item['name'] = response.xpath('//div[@id="name"]').get()
            # item['description'] = response.xpath('//div[@id="description"]').get()

            if title is not None:
                item['title'] = title
                item['url'] = url
                item['main_image'] = main_image
                item['image_list'] = main_image
                item['description'] = description
                item['sub_time'] = sub_time
                item['news_type'] = news_type.replace('分类：', '')
                item['tags'] = list(set(tags))
                print(str(item))
                yield item
