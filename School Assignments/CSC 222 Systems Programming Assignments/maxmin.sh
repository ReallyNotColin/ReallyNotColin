#!bin/bash
i=0
n=0
max=0
min=1

maximum(){
	while [ $n -lt "$#" ]
	do
		#echo "Value of n is $n"
		#echo "args[n] = ${args[n]}"
		if [ "${args[n]}" -gt $max ] ; then
			max="${args[n]}"
		fi		
		n=$((n+1))
	done
	echo "largest parameter: $max";
}
n=0
minimum(){
	while [ $n -lt "$#" ]
	do
		#echo "Value of n is $n"
		#echo "args[n] = ${args[n]}"
		if [ "${args[n]}" -lt $min || "${args[n]}" -eq $min ] ; then
			min="${args[n]}"
		fi
		n=$((n+1))
	done
	echo "smallest parameter: $min";
}
args=("$@")
if [ "$#" -eq 0 ] ; then
	echo "Usage: ./maxmin.sh val [val [val...]]";
	echo "e.g., ./maxmin.sh 7 94 88 9";
else
	echo "Number of arguments: $#"
	echo "First argument: $1"
	echo "Sechond argument: $2"
	maximum "$@"
	minimum "$@"
fi
