# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html
from scrapy.exceptions import DropItem


class CcnovelNewsContentScrapyPipeline(object):
    def __init__(self):
        self.news_set = set()

    # 处理结果去重
    def process_item(self, item, spider):
        title = item['title']
        if title in self.news_set:
            raise DropItem("Duplicate news found:%s" % item)

        self.news_set.add(title)
        return item
