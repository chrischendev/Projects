# -*- coding:utf-8 -*-
# 爬取西诺网
import time
import uuid

import pymysql
import requests
from bs4 import BeautifulSoup


# 爬取
def spider():
    conn, cursor = getDbInfo()
    # 获取新闻类型结果集
    types = getTypes()
    for row in types:
        getData(conn, cursor, row[0], row[1], True)
    cursor.close()
    conn.close()


# 分类爬取内容
def getData(conn, cursor, news_type, url, isHome):
    print(url)
    # 主要内容选择器
    selector = 'body > section > div > div > article'

    # 获取网页代码
    strHtml = requests.get(url)

    # 获取内容 用 content会自动解决乱码问题，text会有乱码，还不知道怎么解决
    content = strHtml.content

    # 解析数据
    soup = BeautifulSoup(content, 'lxml')

    # 解析得到主要的数据集合
    data = soup.select(selector)

    # 遍历数据集合 解析需要的数据 写入数据库
    for i in range(len(data)):
        art = data[i]
        try:
            cls = art.attrs['class']
            if 'excerpt' in cls:
                main_image = art.a.img.attrs['src']  # 主图
                title = art.h2.a.text  # 标题
                url = art.h2.a.attrs['href']  # 链接
                description = art.p.text  # 摘要
                pub_time_str = art.footer.time.text  # 时间
                footer_span = art.select('footer > span')
                footer_span_a = footer_span[1].find_all('a')
                news_tags = getTags(footer_span_a)
                # 特殊情况 HOME下最新的新闻在对应的分类下面并没有出现，所以分类暂时用HOME，也可以从分类标签中去解析，稍后
                if 'HOME' == news_type:
                    news_type = footer_span[0].a.text.replace('分类：', '')

                # 写入数据库
                writeToMysqlDb(conn, cursor, main_image, title, url, description, pub_time_str, news_type, news_tags)
        except Exception as e:
            # print(i)
            print(e)

    # 上面设计的逻辑有问题 应该去找next的连接，每次都去找下一页
    next_page_selector = 'body > section > div > div > div.pagination.pagination-multi > ul > li.next-page > a'
    next_page = soup.select(next_page_selector)
    print('next_page:' + str(len(next_page)))
    # 如果找到下一页就继续执行
    if len(next_page) > 0:
        getData(conn, cursor, news_type, next_page[0].attrs['href'], False)
    pass  # 下面是旧的逻辑 有问题 不执行

    # 最后的一个处理 如果当前处理的是分类首页，则获取分页条数据,找到其他后续分页,递归调用，不是分类首页不用处理
    if isHome:
        # 分页条选择器
        page_selector = 'body > section > div > div > div.pagination.pagination-multi > ul > li > a'

        pages = soup.select(page_selector)
        page_urls = []
        # 搜集分页链接
        for page in pages:
            page_urls.append(page.attrs['href'])
        # 去重
        page_urls = list(set(page_urls))
        # 遍历递归调用
        for page_url in page_urls:
            # print(page_url)
            getData(conn, cursor, news_type, page_url, False)


# 写入数据库
def writeToMysqlDb(conn, cursor, main_image, title, url, description, pub_time_str, news_type, news_tags):
    # sql语句
    sql = 'replace into tb_news values (null,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s);'
    current_time = time.localtime(time.time())
    try:
        # 执行sql语句
        cursor.execute(sql, (
            str(uuid.uuid1()), title, url, news_type, main_image, main_image, 'Chris', '西诺网', description, news_tags,
            pub_time_str, current_time))
        conn.commit()  # 把修改的数据提交到数据库
    except Exception as e:
        print(e)
        conn.rollback()  # 捕捉到错误就回滚


# 获取mysql数据库信息
def getDbInfo():
    # 连接database
    conn = pymysql.connect(host='192.168.0.102', port=3307, user='root', password='root',
                           database='spider_ccnovel_news',
                           charset='UTF8')
    # 得到一个可以执行SQL语句的光标对象
    cursor = conn.cursor()
    return conn, cursor


# 获取分类集合
def getTypes():
    conn, cursor = getDbInfo()
    sql = 'select code,url from tb_news_type;'
    cursor.execute(sql)
    data = cursor.fetchall()
    # 直接返回结果集，或者构建为字典集合返回
    return data


# 获取新闻标签
def getTags(footer_span_a):
    tags = []
    for a in footer_span_a:
        tags.append(a.text)
    return ','.join(tags)


# 执行
if __name__ == '__main__':
    spider()
