package com.indix.bootcamp.parser

import com.indix.bootcamp.models.{Price, Product}
import org.jsoup.nodes.Document
import com.indix.bootcamp.utils.Utils._

class FlipkartParser extends Parser {
  override def parseProduct(document: Document, pageUrl: String): Product = {
    val title = document.select("h1[itemprop=name]").text()
    val description = document.select("#specifications").text()
    Product(title, description, pageUrl)
  }

  // TODO: Fix the price Extraction
  override def parsePrice(document: Document): Price = {
    val listPrice = document.select(".old-price").text()
    val salePrice = document.select("meta[itemprop=price]").attr("content")
    Price(cleanPrice(listPrice), cleanPrice(salePrice))
  }

}

class JabongParser extends Parser {
  override def parseProduct(document: Document, pageUrl: String): Product = {
    val title = document.select("#qa-title-product").text()
    val description = document.select("p[itemprop=description]").text()
    Product(title, description, pageUrl)
  }

  override def parsePrice(document: Document): Price = {
    val listPrice = document.select("span.striked-price").text()
    val salePrice = document.select("span[itemprop=price]").text()
    Price(cleanPrice(listPrice), cleanPrice(salePrice))
  }
}
