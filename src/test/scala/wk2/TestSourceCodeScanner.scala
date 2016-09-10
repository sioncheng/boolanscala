package wk2

import org.scalatest.{FunSpec, ShouldMatchers}

class TestSourceCodeScanner extends FunSpec with ShouldMatchers {

	describe("SourceCodeScanner") {
		it ("should be able to scan all code files") {
			val path = "src/main/scala"
			val scs = new SourceCodeScanner{}
			val codeFiles = scs.scan(path)
			codeFiles.size shouldBe 7
			val codeFileNames = codeFiles.map(x => FileUtil.getName(x))
			codeFileNames.head shouldBe "Main.scala"
			codeFileNames.last shouldBe "SourceCodeScanner.scala"
		}
	}
}