Public Enum GenderType
    Unsepecified = 0
    Male = 1
    Female = 2
    Other = 3
End Enum

Public Class GenderExension
    Private Shared ReadOnly DisplayGender As New Dictionary(Of Integer, String) From {
        {0, "Unsepecified"},
        {1, "Male"},
        {2, "Female"},
        {3, "Other"}
        }
    Public Shared Function GetDisplayName(gender As Integer) As String

        For Each keyValuePair As KeyValuePair(Of Integer, String) In DisplayGender
            If gender = keyValuePair.Key Then
                Return keyValuePair.Value
            End If
        Next

        Return DisplayGender.Item(0)
    End Function

End Class