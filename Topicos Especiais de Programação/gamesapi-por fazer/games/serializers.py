import datetime
from rest_framework import serializers
from .models import Game


class GameSerializer(serializers.ModelSerializer):
    class Meta:
        model = Game
        fields = ('id', 'name', 'release_date', 'game_category')

    def validar_campos(self, game):
        if game.name == None or game.name == '':
            raise serializers.ValidationError('O campo name esta em branco, preencha-o')
        if game.release_date == None or game.release_date == '':
            raise serializers.ValidationError('O campo release_date esta em branco, preencha-o')
        if game.game_category == None or game.game_category == '':
            raise serializers.ValidationError('O campo game_category esta em branco, preencha-o')
        if game.played == None or game.played == '':
            raise serializers.ValidationError('O campo played esta em branco, preencha-o')
        return game

    def validar_nome_repetido(self, nome):
        if Game.objects.filter(name=nome).exists():
            raise serializers.ValidationError('Nome Ja esta sendo utilizado em outro Game')
        return self.field_valid(nome)

    # def validar_delete(self, game):
    #     if game.release_date.date() > datetime.now().date():
    #         return game
    #     else:
    #         raise serializers.ValidationError('Jogo ja lancada, não pode ser excluido')
