
# Архитектура ПО. Семинар 11. Сервис-ориентированные архитектуры

Представить MVP проект с мессенджером, спроектированного в прошлой домашней работе.

---

MVP расшифровывается как Minimum Viable Product. Для этого проекта он представлен кодом на предыдущем [семинаре](https://github.com/Valinetsky/SoftArchSeminar10/ "Семинар 10").

Здесь же рассмотрю использование [JavaFX](https://ru.wikipedia.org/wiki/JavaFX/ "Вики по JavaFX") в контексте приложения-чата.

В коде для этого семинара — три файла. App.java — класс расширяющий Application — загружает сцену, описанную в файле chatroom.fxml. А Controler.java — отвечает за обработку событий. То есть приложение, дизайн и управление не привязаны друг к другу, разработку, соблюдая внутренние стандарты можно вести независимо.

## Работа приложения:

Минимальные условия: считаем, что сервер запущен, и к нему подключен пользователь __ELIZA__.

![Screenshot01 - работа приложения](/img/page01.png "Start screen")

В нижнее текстовое поле пользователь вводит сообщение, и нажав `ENTER`, или кликнув кнопку `Send`, отправляет его в поле __Chat__.

![Screenshot02 - работа приложения](/img/page02.png "Work screen 1")
![Screenshot03 - работа приложения](/img/page03.png "Work screen 2")
![Screenshot04 - работа приложения](/img/page04.png "Work screen 3")
![Screenshot05 - работа приложения](/img/page05.png "Work screen 4")
![Screenshot06 - работа приложения](/img/page06.png "Work screen 5")

## Компоновка приложения
Графический интерфейс редактируется с помощью [Scene Builder](https://gluonhq.com/products/scene-builder/ "Страница Scene Builder"). 

Слева — иерархия объектов окна приложения. Справа — идентификатор _fx:id send_ для кнопки `Send`, и указание на вызов метода _sendButton_ из класса Controller.java. 


![Screenshot07 - работа в Scene Builder](/img/scenebuilder01.png "Work screen 5")

Для текстового поля и соседней с ним кнопки в контроллер введены методы

```java
@FXML
private void sendEnter(KeyEvent event) {
	if (event.getCode() == KeyCode.ENTER) {
		sendMessage();
	}
}
```
и

```java
@FXML
private void sendButton(ActionEvent event) {
	sendMessage();
}
```

вызывающий общий метод обновления окна чата

```java
private void sendMessage() {
	String message = chat.getText();
	String probe = string.getText();
	message = message + probe + System.lineSeparator();
	chat.setText(message);
	string.setText("");
}
```

---

Справа — у поля Editable снята галка, для запрета ввода текста в TextArea с меткой Chat. Такой же запрет установлен для TextArea с меткой Clients.

![Screenshot08 - работа в Scene Builder](/img/scenebuilder02.png "Work screen 5")

---
Аналогичным образом можно было бы смоделировать интерфейс в Figma, однако в контексте написания кода и работающего MVP в конкретном случае использовалась связка JavaFX и Scene Builder. А проектирование UI уже можно отдать в дизайн-команду вместе с работающим прототипом.