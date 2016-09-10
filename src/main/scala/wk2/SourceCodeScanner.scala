package wk2

trait SourceCodeScanner {

	def scan(path: String): Seq[String] = {
		val file = new java.io.File(path)
		val files = file.listFiles()
		files.foldLeft(Vector[String]()) {
			(acc, f) => {
				if (f.isFile) {
					acc :+ f.getAbsolutePath()
				} else {
					acc ++ scan(f.getAbsolutePath())
				}
			}
		}
	}
}