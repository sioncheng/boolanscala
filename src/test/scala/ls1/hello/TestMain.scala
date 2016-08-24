package ls1.hello

import org.scalatest.{FunSpec, ShouldMatchers}

class TestMain extends FunSpec with ShouldMatchers {
	describe("Main") {
		it("can add x and y") {
			Main.add(1, 2) should equal(3)
		}
	}
}