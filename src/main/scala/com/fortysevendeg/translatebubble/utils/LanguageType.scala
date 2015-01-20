/*
 * Copyright (C) 2015 47 Degrees, LLC http://47deg.com hello@47deg.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fortysevendeg.translatebubble.utils

import com.fortysevendeg.translatebubble.utils.LanguageType.LanguageType
import macroid.AppContext

object LanguageType extends Enumeration {

  type LanguageType = Value

  val ARABIC, BULGARIAN, CATALAN, CHINESE_SIMPLIFIED, CHINESE_TRADITIONAL, CZECH, DANISH, DUTCH,
  ENGLISH, ESTONIAN, FINNISH, FRENCH, GERMAN, GREEK, HAITIAN_CREOLE, HEBREW, HINDI, HMONG_DAW, HUNGARIAN,
  INDONESIAN, ITALIAN, JAPANESE, KOREAN, LATVIAN, LITHUANIAN, MALAY, NORWEGIAN, PERSIAN, POLISH, PORTUGUESE,
  ROMANIAN, RUSSIAN, SLOVAK, SLOVENIAN, SPANISH, SWEDISH, THAI, TURKISH, UKRAINIAN, URDU, VIETNAMESE = Value

  def toSortedTuples()(implicit appContext: AppContext) = (stringNames() zip resourceNames).sortBy(_._2)

  private def stringNames(): List[String] = LanguageType.values.toList.map(_.toString)

  private def resourceNames(implicit appContext: AppContext): List[String] =
    LanguageType.values.toList.map {
      v =>
        val id = appContext.get.getResources.getIdentifier(v.toString, "string", appContext.get.getPackageName)
        if (id == 0) v.toString else appContext.get.getString(id)
    }

}

object TypeLanguageTransformer {
  def toMyMemory(value: LanguageType): String = value match {
    case LanguageType.ARABIC => "ar-SA"
    case LanguageType.BULGARIAN => "bg-BG"
    case LanguageType.CATALAN => "ca-ES"
    case LanguageType.CHINESE_SIMPLIFIED => "zh-CN"
    case LanguageType.CHINESE_TRADITIONAL => "zh-TW"
    case LanguageType.CZECH => "cs"
    case LanguageType.DANISH => "da-DK"
    case LanguageType.DUTCH => "nl-AN"
    case LanguageType.ENGLISH => "en-GB"
    case LanguageType.ESTONIAN => "et"
    case LanguageType.FINNISH => "fi-FI"
    case LanguageType.FRENCH => "fr-FR"
    case LanguageType.GERMAN => "de-DE"
    case LanguageType.GREEK => "el-GR"
    case LanguageType.HAITIAN_CREOLE => "ht"
    case LanguageType.HEBREW => "he"
    case LanguageType.HINDI => "hi-IN"
    case LanguageType.HMONG_DAW => "mww"
    case LanguageType.HUNGARIAN => "hu-HU"
    case LanguageType.INDONESIAN => "id-ID"
    case LanguageType.ITALIAN => "it-IT"
    case LanguageType.JAPANESE => "ja-JA"
    case LanguageType.KOREAN => "ko-KR"
    case LanguageType.LATVIAN => "lv"
    case LanguageType.LITHUANIAN => "lt-LT"
    case LanguageType.MALAY => "ms-MY"
    case LanguageType.NORWEGIAN => "no-NO"
    case LanguageType.PERSIAN => "fa-IR"
    case LanguageType.POLISH => "pl-PL"
    case LanguageType.LATVIAN => "lv"
    case LanguageType.PORTUGUESE => "pt-PT"
    case LanguageType.ROMANIAN => "ro-RO"
    case LanguageType.RUSSIAN => "ru-RU"
    case LanguageType.SLOVAK => "sk-SK"
    case LanguageType.SLOVENIAN => "sl-SI"
    case LanguageType.SPANISH => "es-ES"
    case LanguageType.SWEDISH => "sv-SE"
    case LanguageType.THAI => "th-TH"
    case LanguageType.TURKISH => "tr-TR"
    case LanguageType.UKRAINIAN => "uk-UA"
    case LanguageType.URDU => "ur-PK"
    case LanguageType.VIETNAMESE => "vi-VN"
    case _ => "Autodetect"
  }

}
