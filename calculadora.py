import os
sair = 1
while sair == 1:

    print('1 - CONVERSÃO')
    print('2 - CALCULADORA DE BINÁRIOS')
    print('+-*/+-*/+-*/+-*/+-*/')

    op = int(input('Digite sua opção: ')) # Opção de Conversão ou Calculadora

    os.system("cls") # Codigo pra limpar a tela

    if op == 1: # Conversão
        print('1 - Decimal -> Binário')
        print('2 - Decimal -> Hexadecimal')
        print('3 - Binário -> Decimal')
        print('4 - Binário -> Hexadecimal')
        print('5 - Hexadecimal -> Decimal')
        print('6 - Hexadecimal -> Binário')

        op2 = int(input('Digite sua opção: ')) # Opção de Conversão
        
        os.system("cls") # Codigo pra limpar a tela

        if op2 == 1:
            print('Decimal -> Binário')

            decimal = int(input('Digite um número DECIMAL: '))
            print(bin(decimal))

        elif op2 == 2:
            print('Decimal -> Hexadecimal')

            decimal = int(input('Digite um número DECIMAL: '))
            print(hex(decimal))

        elif op2 == 3:
            print('Binário -> Decimal')

            binario = input('Digite um número BINÁRIO: ')
            nmr = int(binario, 2)
            print(nmr)

        elif op2 == 4:
            print('Binário -> Hexadecimal')

            binario = input('Digite um número BINÁRIO: ')
            nmr = int(binario, 2)
            print(hex(nmr))

        elif op2 == 5:
            print('Hexadecimal -> Decimal')

            hexadecimal = input('Digite um número HEXADECIMAL: ')
            nmr = int(hexadecimal, 16)
            print(nmr)

        elif op2 == 6:
            print('Hexadecimal -> Binário')

            hexadecimal = input('Digite um número HEXADECIMAL: ')
            nmr = int(hexadecimal, 16)
            print(bin(nmr))

        else:
            print('Opção Inválida!')

    elif op == 2: # Calculadora
        print('1 - SOMA')
        print('2 - SUBTRAÇÃO')
        print('3 - MULTIPLICAÇÃO')
        print('4 - DIVISÃO')

        op2 = int(input('Digite sua opção: ')) # Opção de Calculo

        if op2 == 1:  # Adição
            n1 = input('Digite um número BINÁRIO: ')
            n2 = input('Digite outro número BINÁRIO: ')

            nmr1 = int(n1, 2)
            nmr2 = int(n2, 2)

            soma = nmr1 + nmr2

            print(bin(soma))

        elif op2 == 2:  # Subtração
            n1 = input('Digite um número BINÁRIO: ')
            n2 = input('Digite outro número BINÁRIO: ')

            nmr1 = int(n1, 2)
            nmr2 = int(n2, 2)

            if nmr2 > nmr1:
                print('Operação Inválida!! --SEGUNDO número é maior que o PRIMEIRO--')

            elif nmr1 > nmr2:
                subtracao = nmr1 - nmr2

                print(bin(subtracao))

            else:
                subtracao = 0

                print(bin(subtracao))

        elif op2 == 3:  # Multiplicação
            n1 = input('Digite um número BINÁRIO: ')
            n2 = input('Digite outro número BINÁRIO: ')

            nmr1 = int(n1, 2)
            nmr2 = int(n2, 2)

            multiplicaçao = nmr1 * nmr2

            print(bin(multiplicaçao))

        elif op2 == 4:  # Divisão
            n1 = input('Digite um número BINÁRIO: ')
            n2 = input('Digite outro número BINÁRIO: ')

            nmr1 = int(n1, 2)
            nmr2 = int(n2, 2)

            if nmr1 >= nmr2:
                divisao = nmr1 // nmr2

                print(bin(divisao))

            else:
                divisao = 0

                print(bin(divisao))

        else:
            print('Opção Inválida!')

    else:
        print('Opção Inválida!') 

    sair = int(input(f'\nSe deseja realizar outra opeção digite > 1 <, ' 
                    ' mas se desejar sair digite > 0 <: '))
    os.system("cls") # Codigo pra limpar a tela
