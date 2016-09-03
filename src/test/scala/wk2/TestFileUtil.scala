package wk2

import org.scalatest.{FunSpec, ShouldMatchers}

class TestFileUtil extends FunSpec with ShouldMatchers {

	describe("FileUtil") {

		it("should get file extension name from abc.txt") {
			FileUtil.getExtensionName("abc.txt") shouldBe "txt"
		}

		it("should get NilExtension name from abc") {
			FileUtil.getExtensionName("abc") shouldBe FileUtil.NilExtension
		}
	}
}