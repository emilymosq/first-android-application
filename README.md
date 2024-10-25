# Cambios en el Login y el Registro

## Login: 

![image](https://github.com/user-attachments/assets/b33cb0b5-641b-4e6b-988a-406451d7e12c)
![image](https://github.com/user-attachments/assets/d5f64966-77e2-4b48-86d1-9c0b5e578d69)
![image](https://github.com/user-attachments/assets/be74cfbd-9b82-4da8-8e34-32f4e7254a2e)

He creado dos variables, donde se almacena el texto ingresado por el usuario en los campos de entrada de UserName y Password, y le indico que elimine cualquier espacio en blanco alrededor del texto con un trim().

Ahora, con un if he comprobado si el campo de username está vacío, donde se muestra un Toast que indica que ingrese su nombre de usuario. Luego se verifica si el campo de contraseña está vacío, si es así, se muestra otro Toast pidiendo la contraseña.

También, se recuperan las credenciales que ya se han guardado previamente en el usuario y contraseña usando un SharedPreferences. Si estas credenciales coinciden con las guardadas, se llama el método launchMain().

En caso de que las credenciales no coinciden, se muestra un Toast indicando “Datos incorrectos.”

## Registro 

![image](https://github.com/user-attachments/assets/f685d8b4-9cc2-44e6-b844-a163d9b864fe)
![image](https://github.com/user-attachments/assets/b92f77d7-ead2-4e5d-af25-8a0e6e9f1051)

De igual manera que el Login, se almacenan los campos de usuario, contraseña y confirmación de contraseña en su respectiva variable. 

También, si alguno de estos tres campos está vacío, se muestra un Toast pidiendo que ingrese la información. Si estas validaciones son correctas, se guardan en SharedPreferences.
