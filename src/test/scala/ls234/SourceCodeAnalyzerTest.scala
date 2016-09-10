package ls234

import org.scalatest.{FunSpec, ShouldMatchers}

class SourceCodeAnalyzerTest extends FunSpec with ShouldMatchers {

	describe("SourceCodeAnalyzer") {
		it("can analyze source code file") {
			val path = "./src/test/resources/sourceCodeSimple.txt"
			val sa = new SourceCodeAnalyzer{}
			val sourceCodeInfo = sa.fromFile(path)
			sourceCodeInfo.name shouldBe "sourceCodeSimple.txt"
			sourceCodeInfo.path shouldBe path
			sourceCodeInfo.count shouldBe 30
		}
	}
}