@echo off
start cmd.exe /k 01-Eureka-Server.bat
timeout /t 12
start cmd.exe /k 02-Cloud-Config-Server.bat
timeout /t 12
start cmd.exe /k 03-Waste-Manager-Address-Service.bat
timeout /t 12
start cmd.exe /k 04-Waste-Manager-Service.bat
timeout /t 12
start cmd.exe /k 05-Gateway-Service.bat
exit