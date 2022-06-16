import org.scalatest._
import org.scalatest.concurrent.Eventually
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers._
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.selenium._
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

import io.github.bonigarcia.wdm.WebDriverManager

class SimpleGoogleSpec
  extends AnyFunSpec
  with BeforeAndAfterAll
  with Eventually
  with Matchers
  with WebBrowser {

  implicit val webDriver: WebDriver = {
    WebDriverManager.chromedriver().setup()
    new ChromeDriver()
  }

  override def afterAll() = {
    quit()
  }

  describe("Google Search Results Page") {
    describe("when searching 'Cheese!'") {
      it("should have the correct title") {
        go to "https://www.google.com"

        click on "q"

        enter("Cheese!")

        submit()

        // Google's search is rendered dynamically with JavaScript.
        eventually { pageTitle should be ("Cheese! - Google Search") }
      }
    }
  }
}
