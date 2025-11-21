import re

texto = "ZONA Zambugeiro 150 "

# 1) remover a primeira palavra (qualquer que seja)
sem_prefixo = re.sub(r"^\S+\s+", "", texto)

# 2) remover tudo a partir do primeiro número
resultado = re.sub(r"\s*\d.*$", "", sem_prefixo).strip()

print(resultado)