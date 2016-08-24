package ls234

class SourceCode(val path:String, val name:String, private val lines: List[String]) {
	def count = lines.length
}

object SourceCode {
	def fromFile(path: String) = {
		import scala.io.{Source, BufferedSource}

		val source = Source.fromFile(path)
		val lines = source.getLines().toList
		val name = path.split("/").last

		new SourceCode(path, name, lines)
	}
}