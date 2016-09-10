package wk2

import org.scalatest.{FunSpec, ShouldMatchers}
import ls234.SourceCodeAnalyzer

class TestCodeBaseAnalyzer extends FunSpec with ShouldMatchers {

	def getCodeBaseAnalyzer() = new CodeBaseAnalyzer with SourceCodeScanner with SourceCodeAnalyzer

	describe("CodeBaseAnalyzer") {

		it("should be able to analyze file number in src recursively") {
			val path = "src/main"
			val result = getCodeBaseAnalyzer().analyzeFileNum(path)
			result("scala") shouldBe 7
			result(FileUtil.NilExtension) shouldBe 1
		}

		it("should be able to analyze average file number in src/main/scala/ls234") {
			val path = "src/main/scala/ls234"
			val result = getCodeBaseAnalyzer().analyzeAvgCodeLine(path)
			result shouldBe Map[String, Int]("scala" -> 13)
		}

		it("should be able to find code file which has most lines in src/main") {
			val path = "src/main"
			val result = getCodeBaseAnalyzer().analyzeMaxCodeLine(path)
			FileUtil.getName(result._1) shouldBe "CodeBaseAnalyzer.scala"
		}

		it("should be able to find top 5 files which has most lines in src/main") {
			implicit val top = 5
			val path = "src/main"
			val result = getCodeBaseAnalyzer().analyzeTopCodeLines(path)
			result.size shouldBe top
			FileUtil.getName(result(0)._1) shouldBe "CodeBaseAnalyzer.scala"
		}
	}
}