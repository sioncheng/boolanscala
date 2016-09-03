package wk2

object Main extends App {

	if (args.length < 1) {
		println("Usage: SourceScanner DirectoryPath")
	} else {
		val result = (new SourceScanner()).scan(args(0))
		result.foreach(x=>{
			println(s"ext: ${x._1}    count:${x._2}")
		})
	}
}