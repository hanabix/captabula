package captabula

import java.io.InputStream

import cats.data.Reader

import captabula.dsl._
import captabula.tabula._

import org.scalatest.wordspec.AnyWordSpec

class E2ESpec extends AnyWordSpec {
  "Capture invoice" when {
    "read from a pdf" should {
      "by rect" in {
        val in = classOf[E2ESpec].getClassLoader.getResourceAsStream("test.pdf")
        val reader: Reader[InputStream, Invoice] = for {
          basic <- rect[InputStream](70, 70, 140, 80)
          regex"(\d{12})$no\D+(\d{8})$code\D+(\d{4})$year\D+(\d{2})$month\D+(\d{2})$day" = basic
        } yield Invoice(no, code, s"$year-$month-$day")
        assert(reader.run(in) == Invoice("111111111111", "11111111", "2011-11-11"))
      }
    }
  }

  case class Invoice(no: String, code: String, created: String)
}
