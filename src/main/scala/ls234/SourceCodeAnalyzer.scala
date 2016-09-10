package ls234

case class SourceCodeInfo(path: String, name: String, count: Int)

trait SourceCodeAnalyzer {
	def fromFile(path: String) = {
		import scala.io.{Source, BufferedSource}

		val source = Source.fromFile(path)
		val lines = source.getLines().toList
		val name = path.split("/").last

		SourceCodeInfo(path, name, lines.size)
	}
}