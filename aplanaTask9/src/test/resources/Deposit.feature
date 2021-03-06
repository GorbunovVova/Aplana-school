#language: ru
Функционал: Вклад

  Сценарий: Вклад в рублях 300 тыс.

    Когда выбирается сервис - "Вклады"
    И выбирается валюта - "Рубли"
    И поле "Сумма вклада" заполняется значением "300000"
    И выбирается срок - "6 месяцев"
    И поле "Ежемесячное пополнение" заполняется значением "50000"
    И отмечается чекбокс - "Ежемесячная капитализация"
    Тогда значения полей равны:
      | Ставка                   | 5.80%      |
      | К снятию через 6 месяцев | 562 350,83 |
      | Пополнение за 6 месяцев  | 250 000    |
      | Начислено                | 12 350,83  |

  Сценарий: Вклад в рублях 500 тыс.

    Когда выбирается сервис - "Вклады"
    И выбирается валюта - "Рубли"
    И поле "Сумма вклада" заполняется значением "500000"
    И выбирается срок - "6 месяцев"
    И поле "Ежемесячное пополнение" заполняется значением "70000"
    И отмечается чекбокс - "Ежемесячная капитализация"
    И отмечается чекбокс - "Частичное снятие"
    Тогда значения полей равны:
      | Ставка                   | 5.65%      |
      | К снятию через 6 месяцев | 869 107,22 |
      | Пополнение за 6 месяцев  | 350 000    |
      | Начислено                | 19 107,22  |