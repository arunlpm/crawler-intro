package com.indix.bootcamp.utils

object Utils {

  def Managed[R](block: => R): Option[R] = {
    try {
      Option(block)
    } catch {
      case e: Exception => None
    }
  }

  def cleanPrice(priceText: String) : Double = {
    if(priceText.nonEmpty){
      priceText.filter(each => each >= '0' && each <= '9').toDouble
    }else{ 0 }
  }

}
