package com.mcjourney.litebrite.storage

import com.mcjourney.litebrite.LiteBrite
import com.mcjourney.litebrite.utils.BlockLoc

import scala.collection.mutable.ListBuffer
import scala.collection.parallel.mutable

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of lightbright.
 * 
 * lightbright can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object LightStore {

  private val lights = new ListBuffer[BlockLoc]

  def add(blockLoc: BlockLoc) = lights += blockLoc
  def get(index: Int) = lights(index)
  def remove(blockLoc: BlockLoc) = lights -= blockLoc
  def where(blockLoc: BlockLoc) = lights.indexOf(blockLoc)
  def size = lights.length
  def values = lights
  def has(blockLoc: BlockLoc) = lights.contains(blockLoc)
}
