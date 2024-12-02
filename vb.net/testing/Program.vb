Module Program
    Sub Main(args As String())

        Dim a As String
        Dim b As String
        Dim Name As Name
        Name.name = "name"

        a = "a"
        b = "b"

        Console.WriteLine(a + b)

    End Sub

    Sub editInput(ByRef name As Name)
        'name.name



    End Sub

    Structure Name
        Dim name As String
    End Structure

    Function getInput(question As String) As String
        Console.WriteLine(question)
        Dim output As String

        output = Console.ReadLine()

        If output.Length < 1 Then

        End If

    End Function


End Module