package ls234

object MainApp extends App {
	if (args.length < 1) {
		println("Usage: CodeAnalyzer FilePath")
	} else {
		val sa = new SourceCodeAnalyzer{}
		val sourceCodeInfo = sa.fromFile(args(0))
		println(s"name: ${sourceCodeInfo.name}    count:${sourceCodeInfo.count}")
	}
}