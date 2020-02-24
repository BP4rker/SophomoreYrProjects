def spell_check(file1, file2):
    dict = open(file1, 'r')
    text = open(file2, 'r')
    dict_list = []
    text_list = []
    text_lines = text.readlines()
    lines = dict.readlines()
    for line in lines:
        dict_list.append(line)
    for words in text_lines:
        text_list.append(words)
    for x in text_list:
        if x not in dict_list:
            print("These words are incorrect:", x)


def main():
    file1 = input("Please enter a file to be used as the dictionary: ")
    file2 = input("Please enter a file to spellcheck: ")
    spell_check(file1, file2)


main()
