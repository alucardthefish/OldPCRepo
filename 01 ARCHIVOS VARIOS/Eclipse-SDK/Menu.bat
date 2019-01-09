:menu
@echo off
color 2f
Title Menu Personalizado
echo             =========================================
echo             =                                       =
echo             =  Bienvenidos a mi Menu Personalizado  =
echo             =                                       =
echo             =========================================
echo.
echo             Que desea hacer?
echo.
echo             1. Buscar en Google.
echo.
echo             2. Ir a Correo Yahoo.
echo.
echo             3. Ir a Correo gmail.
echo.
echo             4. Ir a Correo Hotmail. 
echo.
echo             5. Ir a Hi5.
echo.
echo             6. Ir a Youtube.
echo.
echo             7. Salir de la aplicacion. 
echo.
set/p navegador=         Escriba el numero determinado y pulse ENTER.
if %navegador%== 1 goto google
if %navegador%== 2 goto yahoo
if %navegador%== 3 goto gmail
if %navegador%== 4 goto hotmail
if %navegador%== 5 goto hi5
if %navegador%== 6 goto youtube
if %navegador%== 7 goto salir
if %navegador%== %navegador% goto error
pause>nul
:google
cls
@echo off
start http://www.google.com.co/
exit
:yahoo
cls
start https://login.yahoo.com/config/mail?&.src=ym&.intl=es
exit
:gmail
cls
start https://www.google.com/accounts/ServiceLogin?service=mail&passive=true&rm=false&continue=http%3A%2F%2Fmail.google.com%2Fmail%2F%3Fui%3Dhtml%26zy%3Dl&bsv=1k96igf4806cy&ltmpl=default&ltmplcache=2             
exit
:hotmail
cls
start http://login.live.com/login.srf?wa=wsignin1.0&rpsnv=10&ct=1220114466&rver=4.5.2130.0&wp=MBI&wreply=http:%2F%2Fmail.live.com%2Fdefault.aspx&id=64855
exit
:hi5
cls
start http://hi5.com/
exit
:youtube
cls
start http://es.youtube.com/
exit
:salir
cls
exit
:error
cls
msg * La opcion que eligio no existe, pruebe con otra, Gracias.
goto menu
exit
pause>nul
