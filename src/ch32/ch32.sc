package ch32

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object ch32 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val fut = Future { Thread.sleep(1000); 21 + 21 }//> fut  : scala.concurrent.Future[Int] = Future(<not completed>)
  while (!fut.isCompleted) {
    Thread.sleep(100)
  }
  fut.value                                       //> res0: Option[scala.util.Try[Int]] = Some(Success(42))

  val fut1 = Future { Thread.sleep(1000); 21 + 21 }
                                                  //> fut1  : scala.concurrent.Future[Int] = Future(<not completed>)
  val fut2 = Future { Thread.sleep(1000); 23 + 23 }
                                                  //> fut2  : scala.concurrent.Future[Int] = Future(<not completed>)
  val fut12 = for {
    x <- fut1
    y <- fut2
  } yield x + y                                   //> fut12  : scala.concurrent.Future[Int] = Future(<not completed>)
  while (!fut12.isCompleted) {
    Thread.sleep(100)
  }
  fut12.value                                     //> res1: Option[scala.util.Try[Int]] = Some(Success(88))

  Future.successful { 21 + 21 }                   //> res2: scala.concurrent.Future[Int] = Future(Success(42))
  Future.failed(new Exception("bummer!"))         //> res3: scala.concurrent.Future[Nothing] = Future(Failure(java.lang.Exception:
                                                  //|  bummer!))

  val fut21 = Future { 42 }                       //> fut21  : scala.concurrent.Future[Int] = Future(<not completed>)
  val valid = fut21.filter(res => res > 0)        //> valid  : scala.concurrent.Future[Int] = Future(<not completed>)
  valid.value                                     //> res4: Option[scala.util.Try[Int]] = Some(Success(42))
  val invalid = fut21.filter(res => res < 0)      //> invalid  : scala.concurrent.Future[Int] = Future(<not completed>)
  invalid.value                                   //> res5: Option[scala.util.Try[Int]] = None

  val failure = Future { 42 / 0 }                 //> failure  : scala.concurrent.Future[Int] = Future(<not completed>)
  failure.value                                   //> res6: Option[scala.util.Try[Int]] = None
  val expectedFailure = failure.failed            //> expectedFailure  : scala.concurrent.Future[Throwable] = Future(Success(java.
                                                  //| lang.ArithmeticException: / by zero))
  expectedFailure.value                           //> res7: Option[scala.util.Try[Throwable]] = Some(Success(java.lang.ArithmeticE
                                                  //| xception: / by zero))
  val success = Future { 42 / 1 }                 //> success  : scala.concurrent.Future[Int] = Future(<not completed>)
  while (!success.isCompleted) {
    Thread.sleep(100)
  }
  success.value                                   //> res8: Option[scala.util.Try[Int]] = Some(Success(42))

  val fallback = failure.fallbackTo(success)      //> fallback  : scala.concurrent.Future[Int] = Future(Success(42))
  fallback.value                                  //> res9: Option[scala.util.Try[Int]] = Some(Success(42))
  val failedFallback = failure.fallbackTo(Future { val res = 42; require(res < 0); res })
                                                  //> failedFallback  : scala.concurrent.Future[Int] = Future(<not completed>)
  failedFallback.value                            //> res10: Option[scala.util.Try[Int]] = Some(Failure(java.lang.ArithmeticExcep
                                                  //| tion: / by zero))
  val recovered = failedFallback recover {
    case ex: ArithmeticException => -1
  }                                               //> recovered  : scala.concurrent.Future[Int] = Future(<not completed>)
  recovered.value                                 //> res11: Option[scala.util.Try[Int]] = None
  val unrecovered = fallback recover {
    case ex: ArithmeticException => -1
  }                                               //> unrecovered  : scala.concurrent.Future[Int] = Future(<not completed>)

  val first = success.transform(
    res => res * -1,
    ex => new Exception("see cause", ex))         //> first  : scala.concurrent.Future[Int] = Future(<not completed>)
  while (!first.isCompleted) {
    Thread.sleep(100)
  }
  first.value                                     //> res12: Option[scala.util.Try[Int]] = Some(Success(-42))
  val second = failure.transform(
    res => res * -1,
    ex => new Exception("see cause", ex))         //> second  : scala.concurrent.Future[Int] = Future(<not completed>)
  while (!second.isCompleted) {
    Thread.sleep(100)
  }
  second.value                                    //> res13: Option[scala.util.Try[Int]] = Some(Failure(java.lang.Exception: see 
                                                  //| cause))

}