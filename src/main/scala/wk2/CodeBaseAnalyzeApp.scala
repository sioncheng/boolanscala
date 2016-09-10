package wk2

import ls234.SourceCodeAnalyzer

object CodeBaseAnalyzeApp extends App {

	if (args.length < 1) {
		println("Usage: CodeBaseAnalyzerApp DirectoryPath")
	} else {
		val ca = new CodeBaseAnalyzer with SourceCodeScanner with SourceCodeAnalyzer
		
		val fileNumResult = ca.analyzeFileNum(args(0))
		println("====== analyze file number")
		fileNumResult.foreach(x=>{
			println(s"ext: ${x._1}    count: ${x._2}")
		})
		println("")

		val avgCodeLineResult = ca.analyzeAvgCodeLine(args(0))
		println("====== analyze average code-line number")
		avgCodeLineResult.foreach(x=>{
			println(s"ext: ${x._1}    count: ${x._2}")
		})
		println("")

		val maxCodeLineResult = ca.analyzeMaxCodeLine(args(0))
		println("====== analyze max code-line number")
		println(s"file: ${maxCodeLineResult._1}    code-line: ${maxCodeLineResult._2}")
		println("")

		implicit val top = 5
		val topCodeLinesResult = ca.analyzeTopCodeLines(args(0))
		println(s"====== analyze top ${top} code-line number")
		topCodeLinesResult.foreach(x=>{
			println(s"file: ${x._1}    code-line: ${x._2}")
		})
		println("")
	}
}