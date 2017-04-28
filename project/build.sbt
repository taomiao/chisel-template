import chiselBuild.ChiselDependencies._

unmanagedSourceDirectories in Compile += baseDirectory.value / "chiselBuild"

subProjectsSetting := Seq(
  PackageProject("firrtl"),
  PackageProject("firrtl_interpreter", Some(file("firrtl-interpreter"))),
  PackageProject("chisel3"),
  PackageProject("chisel_testers", Some(file("chisel-testers")))
)
lazy val dummySetting = settingKey[Int]("dummy key")
dummySetting := {
  println("in project/build.sbt")
  println("subProjectsSetting: " + subProjectsSetting.value)
  0
}