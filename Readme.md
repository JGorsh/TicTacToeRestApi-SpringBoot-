- "/gameplay" (GET)---"Введите в Body request (/gameplay/onePlayer), (/gameplay/twoPlayer) id, name, symbol игроков в JSON формате "  

- "/gameplay/onePlayer" (POST)-- первый игрок(возвращает список игроков)

- "/gameplay/twoPlayer" (POST)-- второй игрок (возвращает список игроков)

- "/gameplay/game" (GET)-- отображение игрового поля

- "/gameplay/game/{currentPlayer}/{position}" (GET) -- для начала игры  введите в адрес {currentPlayer} - имя игрока делающего ход, {position} выберите позицию

- "/gameplay/init" (GET) -- для сброса игры 