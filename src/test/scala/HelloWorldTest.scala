import org.scalatest.FunSuite

class HelloWorldTest extends FunSuite {
  test("Test to check if sayHello returns expected result") {
    val helloWorld = new HelloWorld
    assert(helloWorld.sayHello("Deepak") == "Hello, Deepak!")
  }
}
