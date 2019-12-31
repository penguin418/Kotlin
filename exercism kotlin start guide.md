This is Guide for Windows PowerShell Only!

Prerequisite
1. Install Kotlin
<https://kotlinlang.org/docs/tutorials/command-line.html>
(or I can install Kotlin using choco)

2. Install Chocolatey <https://chocolatey.org/install>
> Set-ExecutionPolicy Bypass -Scope Process -Force; iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))

(Optional) Install Kotlin using choco
> choco install kotlinc

3. Install Exercism
> cinst exercism-io-cli
> exercism configure --token=API_KEY

(Optional)
> exercism configure --dir=C:/Users/[UESR]/Documnets/exercism
if i do not, default folder will be c:/Users/[USER]/AppData/Roaming/exercism

Install
> exercism download --exercise=hello-world --track=kotlin
