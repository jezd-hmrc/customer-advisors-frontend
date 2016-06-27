/*
 * Copyright 2016 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.contactadvisors.domain

import uk.gov.hmrc.domain.SaUtr
import uk.gov.hmrc.play.http.HeaderCarrier

import scala.concurrent.Future

trait AdviceRepository {

  def insert(advice: Advice, utr: SaUtr)(implicit hc: HeaderCarrier): Future[StorageResult]

}

sealed trait StorageResult extends Product with Serializable
case object AdviceStored extends StorageResult
case object AdviceAlreadyExists extends StorageResult
final case class UnexpectedError(msg: String) extends StorageResult
