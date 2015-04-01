package org.kimbasoft.akka.actor.typed

import org.kimbasoft.akka.actor.typed.SampleActor.SampleActorException

import scala.concurrent.Future

/**
 * Business interface (trait) of a TypedActor. This interface declares
 * the methods that can be invoked on the Actor (just like on EJBs)
 *
 * @author <a href="steffen.krause@soabridge.com">Steffen Krause</a>
 * @since 1.0
 */
trait SampleActor {

  def fireAndForget(value: String): Unit

  def replyResponseNonBlocking(value: String): Future[String]

  def replyResponseOptionBlocking(value: String): Option[String]

  def replyResponseBlocking(value: String): String

  @throws(classOf[SampleActorException])
  def replyResponseException(value: String): String
}

object SampleActor {

  case class SampleActorException(cause: String) extends Exception

}