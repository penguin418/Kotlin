가이드는 Windows PowerShell만을 위한 것 입니다

설치
> exercism download --exercise=hello-world --track=kotlin
다음의 폴더에 기본적으로 저장될 것입니다 
c:/Users/[USER]/Exercism/

준비
exercism을 사용한 적이 없다면 다음을 설치해야 할 수도 있습니다
1. Kotlin 설치
<https://kotlinlang.org/docs/tutorials/command-line.html>
(or I can install Kotlin using choco)

2. Chocolatey 설치 <https://chocolatey.org/install>
> Set-ExecutionPolicy Bypass -Scope Process -Force; iex ((New-ObjectSystem.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))

(선택 사항) Kotlin을 Choco로 설치할 수도 있습니다
> choco install kotlinc

3. Install Exercism
> cinst exercism-io-cli
> exercism configure --token=API_KEY

(선택 사항) configure를 다른 곳에 저장할 수도 있습니다
*configure의 기본 저장장소는 c:/Users/[USER]/AppData/Roaming/exercism입니다
> exercism configure --dir=C:/Users/[UESR]/Documnets/exercism
