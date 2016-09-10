package wk2

object FileUtil {

	val NilExtension = "no-extension"

	def getExtensionName(filepath: String) = {
		val splittedArr = filepath.split("\\.")
		if (splittedArr.length > 1) {
			splittedArr.last
		} else {
			NilExtension
		}
	}

	def getName(filepath: String) = {
		new java.io.File(filepath).getName
	}
}