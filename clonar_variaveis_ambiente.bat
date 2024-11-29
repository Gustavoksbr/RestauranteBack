@echo off
setlocal enabledelayedexpansion
for %%f in (src\main\resources\*.example) do (
    set "file=%%f"
    set "newfile=!file:.example=!"
    copy "%%f" "!newfile!"
)
