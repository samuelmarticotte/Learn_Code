
def banner():
    print("==================================\nWelcome to BELL QUICK QUERY MAKER\n==================================")
    print("Usage:\nMake a list of iocs in a file: list.txt")

#============================READ AND CLEAN DATA
def read_file(file):
        alist = [line.rstrip() for line in open(file)]
        return alist

def clean_item(item, noise):
    result = item
    for n in noise:
        result = result.replace(n, "")
    return result

def clean_array(array,noise):
    new_array = [clean_item(item, noise) for item in array]
    return new_array

def remove_noise():
    print("hello")


def write_file(file):
    return 0

#============================TREAT LIST
def ask_field():
    field=input("You want to query what field? ")
    return field

def ask_or_and():
    ans = "not_used_yet"
    while True:
        ans = input("Do you want AND or OR? ");
        if ans == "AND" or ans == "OR":
            return ans
        else:
            continue

def ask_regex():
    ans = "not_used_yet"
    while True:
        ans = input("Do you want regex: y/n? ");
        if ans == "y" or ans == "n":
            return ans
        else:
            continue

def ask_clean(array,noise):
    ans = "not_used_yet"
    while True:
        ans = input("Remove all special characters: y/n ")
        if ans == "y" or ans == "n":
            if ans == "y":
                return clean_array(array,noise)
            else:
                array = ask_clean_custom(array)
                return array
        else:
            continue

def ask_clean_custom(array):
        ans="not_yet_used"
        while True:
            ans = input("Remove some custom characters: y/n ")
            if ans == "y" or ans == "n":
                if ans == "y":
                    string = input("Enter special characters separated by comma: ")
                    noise = string.split(",")
                    return clean_array(array,noise)
                else:
                    return array
            else:
                continue

#==============================BUILD QUERY

def build_query(list, field, and_or, regex):
    #ADD regex or not
    if regex is "y":

        list = ["/.*" + s + ".*/" for s in list]
        #print("Added regex...\n{}\n---------------------".format(list))
    else:
        list = ["\"" + s + "\"" for s in list]
        #print("Added parentheses...\n{}\n---------------------".format(list))

    #Add AND OR ORs
    final_list = []
    i = 0
    for item in list:
        i=i+1
        if i is len(list):
            final_list.append(" " + item) #if last item: do not append boolean operator
        else:
            final_list.append(" " + item + " " + and_or)

    #Build final query
    final_query = "".join(final_list)
    #print("Added ANDS OR ORS:\n {}\n---------------------------".format(final_query))
    query = "{}:({})".format(field,final_query)
    return query

def output_query(query):
    print("Final query:\n {}".format(query))

#==============================REAL MAIN

def main():
    banner()
    while True:
        #Read file into list
        file = "list.txt"
        noise = ["hxxts", "hxxt", "[.]", "!", "+", ";", ":", "@", "<", "-", "?", "#", "=", "`", "{", "}", "(", ")","\\", ">", "|", ",", "[", "]", "~", "\""]
        array = read_file(file)
        #Treat the list by asking questions
        field = ask_field()
        and_or = ask_or_and()
        regex = ask_regex()
        #Clean array
        array2 = ask_clean(array, noise)
        #Build query
        query = build_query(array2, field, and_or, regex)
        #Ouput result
        output_query(query)
        #Exit
        exit = input("Exit? (y/n)")
        if exit is "y":
            return 0


#==============================MAIN
if __name__ == '__main__':
    main()

