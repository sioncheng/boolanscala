package wk2

import ls234.SourceCodeAnalyzer

trait CodeBaseAnalyzer {

	this: SourceCodeScanner with SourceCodeAnalyzer =>

	def analyzeFileNum(path: String): Map[String, Int] = {
		groupCodeFiles(path).mapValues(x=>x.size)
	}

	def analyzeAvgCodeLine(path: String) : Map[String, Int] = {
		val codeFiles = groupCodeFiles(path)
		codeFiles.mapValues(x => {
			val codeFileInfos = x.map( y => fromFile(y))
			val totalCodeLines = codeFileInfos.foldLeft(0)(
				(acc, z) => acc + z.count
			)
			totalCodeLines / codeFileInfos.size
		})
	}

	def analyzeMaxCodeLine(path: String): (String, Int) = {
		val codeFiles = scan(path)
		val codeFileLines = codeFiles.map( x => x -> fromFile(x).count)
		codeFileLines.maxBy( y => y._2)
	}

	def analyzeTopCodeLines(path: String)(implicit top: Int = 10): Seq[(String, Int)] = {
		val codeFiles = scan(path)
		val codeFileLines = codeFiles.map( x => x -> fromFile(x).count)
		val sortedFileLinesDesc = codeFileLines.sortBy( x => x._2).reverse
		sortedFileLinesDesc.take(top)
	}

	def groupCodeFiles(path: String):Map[String, Seq[String]] = {
		val codeFiles = scan(path)
		codeFiles.groupBy(x => FileUtil.getExtensionName(x))
	}
}