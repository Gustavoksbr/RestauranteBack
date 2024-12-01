#!/bin/bash

# Caminho para o arquivo .env
envFilePath="src/main/resources/.env"

# Verifica se o arquivo .env existe
if [ -f "$envFilePath" ]; then
    echo "Carregando variáveis do arquivo .env"
    # Lê cada linha do arquivo
    while IFS= read -r line || [ -n "$line" ]; do
        # Remove espaços em branco e ignora comentários
        line=$(echo "$line" | xargs)
        if [[ -n "$line" && ! "$line" =~ ^# ]]; then
            # Divide em chave e valor usando '=' como delimitador
            IFS='=' read -r key value <<< "$line"
            key=$(echo "$key" | xargs)
            value=$(echo "$value" | xargs)
            # Define a variável de ambiente
            export "$key"="$value"
            echo "Set $key to $value"
        fi
    done < "$envFilePath"
fi