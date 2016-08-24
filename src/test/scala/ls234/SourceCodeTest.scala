package ls234

import org.scalatest.{FunSpec, ShouldMatchers}

class SourceCodeTest extends FunSpec with ShouldMatchers {

	describe("SourceCode") {
		it("can analyze source code file") {
			val path = "./src/test/resources/sourceCodeSimple.txt"
			val sourceCode = SourceCode.fromFile(path)
			sourceCode.name shouldBe "sourceCodeSimple.txt"
			sourceCode.path shouldBe path
			sourceCode.count shouldBe 30
		}
	}
}