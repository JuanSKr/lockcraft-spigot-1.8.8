# 🔐 LockCraft
### ⚠️ This plugin is still in a very early stage of development. This is only a first version with very simple features. It will receive major updates. ⚠️

## 📦 How to use:

1. Download the latest version of the plugin.
2. Place the downloaded .jar file into your Minecraft server's plugins directory.
3. Restart your server or use a plugin manager to load the plugin without restarting.

## 🤝 Contributing

Contributions, issues and feature requests are welcome! Feel free to check.

## 📝 License

This project is [MIT](LICENSE) licensed.

## ⚒️  Programming languages utilized in the development of this application:
<ul style="list-style-type: none;">
  <li>Java 
    <br><img src="https://github.com/devicons/devicon/blob/master/icons/java/java-original-wordmark.svg" title="Java" alt="Java" width="60" height="60"/></li>
</ul>

## ❔ Main features:
- Register:
  - The first time a user logs on to the server and is not registered, he must do so.
  - The register consists of a 5-character numeric pin from 1 to 9. 
  - Once registered, the user and password will be stored in the file 'players.yml'.
  - The password will be stored encrypted, so no one will have access to it. Not even the server owner.
  - The register stage will have a button to reset the PIN in case of error.
- Login:
  - The user will have a maximum of 3 attempts to log in.
  - If you fail all 3 attempts you will be kicked from the server.
  - The login stage will have a button to reset the PIN in case of error.
- Modify your PIN:
  - For security reasons, the user will have only 1 attempt to fail the PIN.
  - If you fail, you will be kicked from the server.
  - The modify stage will have a button to reset the PIN in case of error.
  - The password is changed and re-encrypted in the 'players.yml' file.

## 💫 Available commands:
- /modifypin:
  - The user will be able to use this command to modify his PIN. The current PIN must be entered, followed by the new one.
- /lc-reload:
  - This command reloads the plugin. It is available only for users with OP permissions. If a user without OP permissions tries to use this command, this will be notified in the console.
- /help:
  - Gives you all available plugin commands.
- /version:
  - It gives you the version of the plugin that is installed on the server.

## 📚  Libraries implemented in the development process: 
- Spigot (spigot-1.8.8-R0.1-SNAPSHOT-latest)

<details>
  <summary>📸 Screenshots</summary>
  
  - This is the register screen:
  
  ![Register](https://i.imgur.com/hXMFIA4.png)

  - This is the screen after registering:
  
  ![AfterRegister](https://i.imgur.com/pAPUOXL.png)

  - This is the login screen:
  
  ![Login](https://i.imgur.com/8ar5i2f.png)

  - This is the screen after logging in:
  
  ![AfterLogin](https://i.imgur.com/n1BvFHS.png)

  - This is the screen after a failed login:
  
  ![AfterFailed](https://i.imgur.com/tuio8fh.png)

  - This is the modify screen:
  
  ![Modify](https://i.imgur.com/ub8cJGX.png)

  - This is the screen after modification:
  
  ![AfterModify](https://i.imgur.com/F90NmUh.png)

  - This is an example of an encrypted password:
  
  ![EncriptedPassExample](https://i.imgur.com/q6Mp9Dq.png)

  - This is the help screen:
  
  ![Help](https://i.imgur.com/xgQzcIc.png)
</details>

