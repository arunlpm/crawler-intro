package com.indix.bootcamp.parser

import com.indix.bootcamp.utils.TestUtils
import org.scalatest.{Matchers, FunSuite}


class JabongParserTest extends FunSuite with Matchers with TestUtils {

  test("should parse product page") {
    val document = readDocument("/jabong/jabong_productPage.html")
    val parser = new JabongParser
    val parsedProduct = parser.parseProduct(document, "http://www.jabong.com/men/clothing/denims/jeans/?source=topnav")
    parsedProduct.name should be("Blue Stretch Skinny Fit Jeans")
    parsedProduct.description should include("Complete your off-duty look for the day by wearing this pair of blue jeans by United Colors of Benetton. Ideal for all those casual outings with friends, these skinny-fit jeans will look great when clubbed with a trendy polo T-shirt and sneakers. Made from stretch cotton fabric, these jeans will keep you at ease all day long.")
  }

  test("should parse prices from product page") {
    val document = readDocument("/jabong/jabong_productPage.html")
    val parser = new JabongParser
    val parsedPrice = parser.parsePrice(document)
    parsedPrice.salePrice should be(3999.0)
  }

}