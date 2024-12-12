Public Class UtilityMethods




    Public Shared Function GetInputString(question) As String
        Dim output As String

        Do
            Console.WriteLine(question)
            output = Console.ReadLine()
            If output.Equals("x") Then
                Exit Do
            End If

            ClearCurrentConsoleLine()
        Loop Until Not String.IsNullOrEmpty(output)


        Console.WriteLine($"{question}{output}")
        Return output

    End Function

    Public Shared Function GetInputInt(question) As Integer
        Dim output As Integer
        Dim input As String
        Dim failed As Boolean = False

        Do
            Console.WriteLine(question)
            input = Console.ReadLine()
            If input.Equals("x") Then
                Exit Do
            End If

            Try
                output = Integer.Parse(input)

            Catch ex As ArgumentException
                WriteAt(0, 0, "Enter a number", ConsoleColor.Red)
                Console.SetCursorPosition(0, 6)
                failed = True
            Catch ex As FormatException
                WriteAt(0, 0, "Enter a valid number", ConsoleColor.Red)
                Console.SetCursorPosition(0, 6)
                failed = True
            Catch ex As OverflowException
                WriteAt(0, 0, "Enter a smaller number", ConsoleColor.Red)
                Console.SetCursorPosition(0, 6)
                failed = True
            End Try
            ClearCurrentConsoleLine()
        Loop Until output >= 16 AndAlso output < 100
        If failed Then
            ClearNotification()
        End If
        Console.WriteLine($"{question}{output}")
        Return output

    End Function


    Public Shared Sub WriteLineColor(inputText As String, Optional ByVal color As ConsoleColor = ConsoleColor.White)
        Console.ForegroundColor = color
        Console.Write(inputText)
        Console.ResetColor()

    End Sub

    Public Shared Sub ClearCurrentConsoleLine()
        Dim consoleWidth As Integer = Console.WindowWidth
        Dim currentLineCursor As Integer = Console.CursorTop - 2
        Dim inputLength As Integer = Console.CursorLeft
        Dim rowsToClear As Integer = Math.Ceiling(inputLength Mod consoleWidth)

        For i As Integer = 0 To rowsToClear
            Console.SetCursorPosition(0, currentLineCursor + i)
            Console.Write(New String(" "c, consoleWidth))
        Next

        Console.SetCursorPosition(0, currentLineCursor)

    End Sub

    Public Shared Sub ClearNotification()
        Console.SetCursorPosition(0, 0)
        Console.Write(New String(" "c, Console.WindowWidth))
        Console.SetCursorPosition(0, 6)
    End Sub


    Public Shared Sub WriteAt(x As Integer, y As Integer, value As String, Optional ByVal color As ConsoleColor = ConsoleColor.White)
        Console.SetCursorPosition(x, y)
        Console.ForegroundColor = color
        Console.Write(value)
        Console.ResetColor()
    End Sub

    Public Shared Function TrimString(maxStringWidth As Integer, value As String) As String
        If (value.Length > maxStringWidth) Then
            Return value.Substring(0, maxStringWidth - 4) + "..."
        End If

        Return value
    End Function

End Class
