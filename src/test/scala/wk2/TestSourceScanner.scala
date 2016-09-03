package wk2

import org.scalatest.{FunSpec, ShouldMatchers}

class TestSourceScanner extends FunSpec with ShouldMatchers {

	describe("TestSourceScanner") {

		it("should be able to scan all source file in /src recursively") {
			val directoryPath = "src/main"
			println(new java.io.File(directoryPath).getAbsolutePath)
			val result = (new SourceScanner()).scan(directoryPath)
			result("scala") shouldBe 6
			result(FileUtil.NilExtension) shouldBe 1
		}
	}
}