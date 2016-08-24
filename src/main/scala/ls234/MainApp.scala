package ls234

object MainApp extends App {
	if (args.length < 1) {
		println("Usage: CodeAnalyzer FilePath")
	} else {
		val sourceCode = SourceCode.fromFile(args(0))
		println(s"name: ${sourceCode.name}    count:${sourceCode.count}")
	}
}