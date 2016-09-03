package wk2

class SourceScanner {

	import java.io._

	def scan(directoryPath: String): Map[String, Int] = {
		new File(directoryPath).listFiles().foldLeft(Map[String, Int]()) {
			(acc, f) => {
				if(f.isFile()) {
					val ext = FileUtil.getExtensionName(f.getName())
					if(acc.contains(ext)) {
						acc + (ext -> (acc(ext) + 1))
					} else {
						acc + (ext -> 1)
					}
				} else {
					val result = scan(f.getAbsolutePath())
					combine(acc, result)
				}
			}
		}
	}

	def combine(ma:Map[String, Int], mb:Map[String, Int]) = {
		val hm = scala.collection.mutable.HashMap[String,Int]()

		def ff (x:(String, Int)) = {
			if (hm.contains(x._1)) {
				hm(x._1) = hm(x._1) + x._2
			} else {
				hm(x._1) = x._2
			}
		}

		ma.foreach(ff)
		mb.foreach(ff)

		hm.toMap
	}
}