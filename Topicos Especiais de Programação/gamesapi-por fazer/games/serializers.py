import datetime
from rest_framework import serializers
from rest_framework.relations import SlugRelatedField

from .models import Game, GameCategory, Score, Player


class GameSerializer(serializers.HyperlinkedModelSerializer):
    game_category = SlugRelatedField(queryset=GameCategory.objects.all(), slug_field='name')

    class Meta:
        model = Game
        fields = (
            'url',
            'game_category',
            'name',
            'release_date',
            'played'
        )

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


class GameCategorySerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = GameCategory
        fields = ('url', 'pk', 'name', 'games')


class ScoreSerializer(serializers.HyperlinkedModelSerializer):
    game = serializers.SlugRelatedField(queryset=Game.objects.all(), slug_field='name')
    player = serializers.SlugRelatedField(queryset=Player.objects.all(), slug_field='name')

    class Meta:
        model = Score
        fields = (
            'url',
            'pk',
            'score',
            'score_date',
            'player',
            'game'
        )

    def validar_campos(self, score):
        if score.game is None or score.played is None:
            raise serializers.ValidationError('Os campos game ou played podem estar vazios, preencha-os')
        elif score.score < 0 or score.score is None:
            raise serializers.ValidationError('O campo score não foi preenchido corretamente')
        elif score.score_date > datetime.now().date():
            raise serializers.ValidationError('O campo score_date não foi preenchido corretamente')


class PlayerSerializer(serializers.HyperlinkedModelSerializer):
    scores = ScoreSerializer(many=True, read_only=True)

    class Meta:
        model = Player
        fields = (
            'url',
            'name',
            'gender',
            'scores'
        )
