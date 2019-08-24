# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# https://docs.scrapy.org/en/latest/topics/items.html

import scrapy


class CcnovelNewsContentScrapyItem(scrapy.Item):
    # define the fields for your item here like:
    title = scrapy.Field()
    url = scrapy.Field()
    main_image = scrapy.Field()
    image_list = scrapy.Field()
    description = scrapy.Field()
    sub_time = scrapy.Field()
    tags = scrapy.Field()
    news_type = scrapy.Field()
    pass
